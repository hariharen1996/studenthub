package com.studenthub.resultsetextractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StudentAddrResultSetExtractor implements ResultSetExtractor<Map<String, List<String>>> {

    @Override
    public Map<String, List<String>> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<String, List<String>> students = new HashMap<>();

        while (rs.next()) {
            String name = rs.getString("name");
            String address = rs.getString("address");
            List<String> studentNames = students.get(address);

            if (studentNames == null) {
                ArrayList<String> newStudents = new ArrayList<>();
                newStudents.add(name);
                students.put(address, newStudents);
            }else{
                studentNames.add(name);
            }
        }

        return students;
    }

}
