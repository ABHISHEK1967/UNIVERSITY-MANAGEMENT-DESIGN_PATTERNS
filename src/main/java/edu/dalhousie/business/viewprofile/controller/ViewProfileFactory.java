package edu.dalhousie.business.viewprofile.controller;

import edu.dalhousie.business.viewprofile.business.UserType;
import edu.dalhousie.business.viewprofile.database.IUpdateProfileConnection;
import edu.dalhousie.business.viewprofile.database.IViewProfileConnection;
import edu.dalhousie.business.viewprofile.database.UpdateProfileConnection;
import edu.dalhousie.business.viewprofile.database.ViewProfileConnection;
import edu.dalhousie.business.viewprofile.model.IViewProfileModel;
import edu.dalhousie.business.viewprofile.model.ViewProfileModel;
import edu.dalhousie.business.viewprofile.business.IUserType;

public class ViewProfileFactory {
    private static ViewProfileFactory viewProfileFactory = null;
    IViewProfileModel viewProfileModel;
    IViewProfileConnection viewProfileConnection;
    IUpdateProfileConnection updateProfileConnection;
    IUserType userType;

    public ViewProfileFactory() {
        viewProfileConnection = new ViewProfileConnection();
        updateProfileConnection = new UpdateProfileConnection();
        viewProfileModel = new ViewProfileModel();
        userType = new UserType();
    }

    public static ViewProfileFactory initialize() {
        if (viewProfileFactory == null) {
            viewProfileFactory = new ViewProfileFactory();
        }
        return viewProfileFactory;
    }

    public IViewProfileModel getViewProfileModel() {
        return viewProfileModel;
    }

    public IViewProfileConnection getViewProfileConnection() {
        return viewProfileConnection;
    }

    public IUpdateProfileConnection getUpdateProfileConnection() {
        return updateProfileConnection;
    }

    public IUserType getUserType() {
        return userType;
    }
}
