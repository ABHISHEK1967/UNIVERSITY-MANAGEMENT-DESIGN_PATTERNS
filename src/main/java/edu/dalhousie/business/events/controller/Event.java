/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.controller;

import edu.dalhousie.business.events.database.InsertWinnerNameQueryBuilder;
import edu.dalhousie.business.events.model.Event.EventNotification;
import edu.dalhousie.business.events.model.Judge.EventJudge;
import edu.dalhousie.business.events.controller.state.StateAtEnd;
import edu.dalhousie.business.events.controller.state.StateAtStart;
import edu.dalhousie.business.events.controller.state.StateContext;
import edu.dalhousie.business.events.controller.state.StateInProgress;
import edu.dalhousie.business.events.model.Winner.EventWinner;
import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

import java.sql.Connection;
import java.sql.Statement;

public class Event {
    public String eventName;
    public String eventLocation;
    public String eventDate;
    public String eventTime;
    public String eventDescription;
    protected StateContext stateContext;
    protected StateAtStart stateAtStart;
    protected StateAtEnd stateAtEnd;
    protected StateInProgress stateInProgress;
    public ICommonPrinting studentView;
    public EventWinner eventWinner;
    public EventJudge eventJudge;
    EventNotification eventNotification;
    private static IDatabaseConnection IDatabaseConnection;
    private InsertWinnerNameQueryBuilder insertWinnerNameQueryBuilder;

    public Event(){}

    public Event(String eventName,
                 String eventLocation,
                 String eventDate,
                 String eventTime,
                 String eventDescription){
        this.stateContext = new StateContext();
        this.stateAtStart = new StateAtStart();
        this.stateAtEnd = new StateAtEnd();
        this.stateInProgress = new StateInProgress();
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventDescription = eventDescription;
        this.studentView = CommonPrinting.getInstance();
        this.stateAtStart.performStateTransition(stateContext);
        this.eventJudge = new EventJudge();
        this.eventWinner = new EventWinner();
        this.eventNotification = new EventNotification();
        this.IDatabaseConnection = DatabaseConnectivity.getInstance();
        this.insertWinnerNameQueryBuilder = new InsertWinnerNameQueryBuilder();
    }
    public void EventProgress() throws Exception {
        this.stateInProgress.performStateTransition(stateContext);
        this.eventJudge.setJudgeName();
        this.studentView.showMessage("Enter Winner name:");
        String winnerName = this.studentView.getString();
        System.out.println(winnerName);
        this.eventWinner.setWinnerName(winnerName);
        this.studentView.showMessage("The"+ this.eventJudge.getJudgeName() +
                " announces the winner as: "+
                this.eventWinner.getWinnerName());
        this.eventNotification.sendWinnerMessage();
            final Connection connection =
                    IDatabaseConnection.getDatabaseConnection();
            final Statement statement =
                    connection.createStatement();
            statement
                    .executeUpdate(
                            this.insertWinnerNameQueryBuilder
                                    .insertWinnerName(this.eventWinner.getWinnerName())
                    );


        this.stateAtEnd.performStateTransition(stateContext);
    }

    public void getEventInfo(){
        this.studentView.showMessage("Event Name : "+ eventName);
        this.studentView.showMessage("Event Location : "+ eventLocation);
        this.studentView.showMessage("Event Date : "+ eventDate);
        this.studentView.showMessage("Event Time : "+ eventTime);
        this.studentView.showMessage("Event Description : "+ eventDescription);
    }
}
