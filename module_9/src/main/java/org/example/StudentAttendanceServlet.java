package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.StudentAttendanceDto;

import java.io.*;
import java.sql.*;
import java.util.*;

@WebServlet("/attendance")
public class StudentAttendanceServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "nurdau50";


    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String selectedGroup = req.getParameter("groupId");

        ArrayList<StudentAttendanceDto> list = getAttendanceFromDB(selectedGroup);
        ArrayList<Map<String, String>> groups = getGroupsFromDB();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Attendance</h1>");

        out.println("<form action='/attendance' method='post'>");
        out.println("Name: <input type='text' name='name' required><br>");
        out.println("Group: <select name='groupId'>");
        for(Map<String, String> group : groups) {
            out.println("<option value='"+group.get("id")+"'>"+group.get("name")+"</option>");
        }
        out.println("</select><br>");
        out.println("Attended: <select name='attended'><option value='true'>Yes</option><option value='false'>No</option></select><br>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");

        out.println("<form method='get' action='/attendance'>");
        out.println("Filter by group: ");
        out.println("<select name='groupId' onchange='this.form.submit()'>");
        out.println("<option value=''>All groups</option>");
        for (Map<String, String> g : groups) {
            String selected = g.get("id").equals(selectedGroup) ? "selected" : "";
            out.println("<option value='" + g.get("id") + "' " + selected + ">" + g.get("name") + "</option>");
        }
        out.println("</select>");
        out.println("</form>");


        out.println("<table>");
        out.println("<tr><th>Name</th><th>Group</th><th>Attended</th></tr>");
        if(list.isEmpty()){
            out.println("</table>");
            out.println("<h1>No Data</h1>");
        }
        for (StudentAttendanceDto studentsAttendanceDto : list) {
            out.println("<tr>");
            out.println("<td>" + studentsAttendanceDto.getName() + "</td>");
            out.println("<td>" + studentsAttendanceDto.getGroupName() + "</td>");
            out.println("<td>" + (studentsAttendanceDto.isAttended() ? "Yes":"No") + "</td>");
            out.println("<td>");
            out.println("<form method='post' action='/attendance'>");
            out.println("<input type='hidden' name='deleteId' value='"+studentsAttendanceDto.getId()+"'>");
            out.println("<input type='submit' value='Delete'>");
            out.println("</form>");
            out.println("</td>");
            out.println("</tr>");
        }
        out.println("</table></body></html>");
    }


    private ArrayList<StudentAttendanceDto> getAttendanceFromDB(String groupId) {
        ArrayList<StudentAttendanceDto> list = new ArrayList<>();
        String sql = "SELECT s.id, s.name, s.is_attended, g.name AS group_name FROM students s JOIN groups g ON s.group_id = g.id";
        if (groupId != null && !groupId.isEmpty()) {
            sql += " WHERE g.id = "+Integer.parseInt(groupId);
        }
        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                StudentAttendanceDto dto = StudentAttendanceDto.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .groupName(rs.getString("group_name"))
                        .isAttended(rs.getBoolean("is_attended"))
                        .build();
                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteId = req.getParameter("deleteId");
        if (deleteId != null && !deleteId.isEmpty()) {
            deleteStudentById(Integer.parseInt(deleteId));
            resp.sendRedirect("/attendance");
            return;
        }


        String name = req.getParameter("name");
        int groupName = Integer.parseInt(req.getParameter("groupId"));
        Boolean isAttended = Boolean.parseBoolean(req.getParameter("attended"));
        String sql = "insert into students (name, is_attended, group_id) values ('";
        sql += name + "', " + isAttended + ", '" + groupName + "')";

        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ) {
            int rs = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/attendance");
    }

    private ArrayList<Map<String, String>> getGroupsFromDB(){
        ArrayList<Map<String, String>> list = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from groups");) {

            while (rs.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("id", rs.getString("id"));
                map.put("name", rs.getString("name"));
                list.add(map);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    private void deleteStudentById(int id) {
        String sql = "delete from students where id = " + id;
        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            int rs = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
