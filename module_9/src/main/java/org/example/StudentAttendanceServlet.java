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

        ArrayList<StudentAttendanceDto> list = getAttendanceFromDB();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Attendance</h1>");

        out.println("<form action='/attendance' method='post'>");
        out.println("Name: <input type='text' name='name' required><br>");
        out.println("Group: <input type='text' name='group' required><br>");
        out.println("Attended: <select name='attended'><option value='true'>Yes</option><option value='false'>No</option></select><br>");
        out.println("<input type='submit' value='Submit'>");
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
            out.println("</tr>");
        }
        out.println("</table></body></html>");
    }

    private ArrayList<StudentAttendanceDto> getAttendanceFromDB() {
        ArrayList<StudentAttendanceDto> list = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from students");) {

            while (rs.next()) {
                StudentAttendanceDto dto = StudentAttendanceDto.builder()
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
        String name = req.getParameter("name");
        String groupName = req.getParameter("group");
        Boolean isAttended = Boolean.parseBoolean(req.getParameter("attended"));
        String sql = "insert into students (name, is_attended, group_name) values ('";
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

    @Override
    public void destroy() {
        // desroy
    }
}
