package edu.dalhousie.business.courseregistration.database;

import edu.dalhousie.business.courseregistration.constants.CourseRegistrationConstants;
import edu.dalhousie.business.courseregistration.model.Course;
import edu.dalhousie.controllers.User;
import edu.dalhousie.controllers.UserSession;
import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.logger.ILogger;
import edu.dalhousie.logger.LoggerAbstractFactory;
import edu.dalhousie.utilities.Constants;

import java.sql.Connection;
import java.sql.Statement;

public class RegisterCourse implements IRegisterCourse {
    private static IDatabaseConnection IDatabaseConnection;

    @Override
    public int registerForSpecificCourse(Course course) {
        User user = UserSession.getInstance().getUser();

        int result = -1;
        int studentId = 2;
        System.out.println("user " + user);
        String query = CourseRegistrationConstants.REGISTER_COURSE_QUERY
            .replace("tableName", Constants.COURSE_ENROLMENTS_TABLE)
            .replace("studentId", studentId + "")
            .replace("courseId", course.getCourseId() + "");

        int updatedSeats = course.getAvailableSeats() - 1;
        String updateQuery = CourseRegistrationConstants.UPDATE_COURSE_AVAILABILITY_QUERY
            .replace("tableName", Constants.COURSES_TABLE)
            .replace("courseId", course.getCourseId() + "")
            .replace("availableSeats", updatedSeats + "");

        try {
            IDatabaseConnection = DatabaseConnectivity.getInstance();
            final Connection connection = IDatabaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            result = statement.executeUpdate(query);
            statement.executeUpdate(updateQuery);
        } catch (Exception exception) {
            ILogger logger = LoggerAbstractFactory.getFactory().newLoggerInstance();
            logger.error(RegisterCourse.class.toString(), exception.getMessage());
            exception.printStackTrace();
        }
        return result;
    }
}
