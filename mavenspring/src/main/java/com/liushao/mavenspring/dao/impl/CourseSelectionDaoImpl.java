package com.liushao.mavenspring.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.liushao.mavenspring.common.CourseSelection;
import com.liushao.mavenspring.dao.CourseSelectionDao;

@Repository
public class CourseSelectionDaoImpl implements CourseSelectionDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<CourseSelection> rowMapper;
	
	public CourseSelectionDaoImpl() {
		rowMapper  = new RowMapper<CourseSelection>() {

			@Override
			public CourseSelection mapRow(ResultSet rs, int rowNum) throws SQLException {
				CourseSelection courseSelection = new CourseSelection();
				courseSelection.setId(rs.getLong("id"));
				courseSelection.setStuId(rs.getLong("stuId"));
				courseSelection.setCourse_id(rs.getLong("course_id"));
				courseSelection.setComment(rs.getString("comment"));
				return courseSelection;
			}
		};
	}

	@Override
	public int saveCourseSelection(CourseSelection courseSelection) {
		return jdbcTemplate.update("insert into course_selection(stuId,course_id) values(?,?)",
				new Object[] { courseSelection.getStuId(), courseSelection.getCourse_id()});
	}

}
