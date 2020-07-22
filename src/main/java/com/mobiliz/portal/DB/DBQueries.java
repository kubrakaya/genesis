package com.mobiliz.portal.DB;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.json.JSONArray;

import javax.swing.plaf.synth.Region;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class DBQueries extends DBeaverConnection {

    private static String QUERY = "";
    private DBeaverConnection dBeaverConnection = null;
    private Connection connection = null;

    private static final Logger logger = Logger.getLogger(DBQueries.class.getName());


    public DBQueries() {

        try {
            dBeaverConnection = new DBeaverConnection();
            connection = dBeaverConnection.getConnection();


        } catch (Exception ex) {
            System.out.println("Catch message in DBQueries method " + ex.getMessage());
            logger.info("error in initializing dBeaverConnection");
        }


    }

    public int get_Data_From_ReportRequests(String startDate, String endDate) throws Exception {

        QUERY = "select count(*) from eMOVE_TEST.rs.REPORTREQUESTS where STARTTIME = ? and ENDTIME = ? ";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {

            preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setString(1, startDate);
            preparedStatement.setString(2, endDate);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }


        } catch (Exception e) {
            System.out.println("Error in get_Data_From_ReportRequests");
            System.out.println(e.getStackTrace());
            throw e;

        } finally {

            dBeaverConnection.closePrepStatement(preparedStatement);
            dBeaverConnection.closeResultSet(resultSet);


        }
        return count;
    }

    public JSONArray get_MobileUnits_From_ViewVMOBILEUNIT(String companyName) throws Exception {

        QUERY = "SELECT MUID FROM eMOVE_TEST.dbo.V_MOBILEUNIT where COMPANYNAME like '%" + companyName + "%'";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        JSONArray plateList = new JSONArray();

        try {

            preparedStatement = connection.prepareStatement(QUERY);


            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                plateList.put(resultSet.getString("MUID"));
            }


        } catch (Exception e) {
            System.out.println("Error in getPlatesFrom_V_MOBILEUNIT");
            System.out.println(e.getStackTrace());
            throw e;

        } finally {

            dBeaverConnection.closePrepStatement(preparedStatement);
            dBeaverConnection.closeResultSet(resultSet);


        }
        return plateList;
    }


    public ArrayList<Map> get_Data_From_OUTBOUND(int MUID) throws Exception {


        QUERY = "SELECT * FROM eMOVE_TEST.dbo.OUTBOUND WHERE MUID = " + MUID;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        ArrayList<Map> allRowsMap = new ArrayList<Map>();


        try {

            preparedStatement = connection.prepareStatement(QUERY);


            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Map oneRowMap = new HashMap();

                oneRowMap.put("MUID", resultSet.getString("MUID"));

                oneRowMap.put("TIME", resultSet.getString("TIME"));

                oneRowMap.put("OUTBOUNDID", resultSet.getInt("OUTBOUNDID"));

                oneRowMap.put("STATUS", resultSet.getString("STATUS"));

                oneRowMap.put("MESSAGE", resultSet.getString("MESSAGE"));

                oneRowMap.put("CAUSE", resultSet.getString("CAUSE"));

                oneRowMap.put("GROUPID", resultSet.getString("GROUPID"));

                allRowsMap.add(oneRowMap);

            }


        } catch (Exception e) {
            System.out.println("Error in THE METHOD get_Data_From_OUTBOUND");
            System.out.println(e.getStackTrace());
            throw e;

        } finally {

            dBeaverConnection.closePrepStatement(preparedStatement);
            dBeaverConnection.closeResultSet(resultSet);


        }
        return allRowsMap;
    }


    public ArrayList<Map> get_Data_From_OUTBOUNDLOG(int MUID) throws Exception {


        QUERY = "SELECT * FROM eMOVE_TEST.dbo.OUTBOUNDLOG WHERE MUID = " + MUID;

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        ArrayList<Map> allRowsMap = new ArrayList<Map>();


        try {

            preparedStatement = connection.prepareStatement(QUERY);


            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Map oneRowMap = new HashMap();

                oneRowMap.put("MUID", resultSet.getString("MUID"));

                oneRowMap.put("PROCESSTIME", resultSet.getString("PROCESSTIME"));

                oneRowMap.put("OUTBOUNDID", resultSet.getInt("OUTBOUNDID"));

                oneRowMap.put("STATUS", resultSet.getString("STATUS"));

                oneRowMap.put("TIME", resultSet.getString("TIME"));

                oneRowMap.put("MESSAGE", resultSet.getString("MESSAGE"));

                oneRowMap.put("CAUSE", resultSet.getString("CAUSE"));

                oneRowMap.put("GROUPID", resultSet.getString("GROUPID"));

                allRowsMap.add(oneRowMap);

            }


        } catch (Exception e) {
            System.out.println("Error in THE METHOD get_Data_From_OUTBOUNDLOG");
            System.out.println(e.getStackTrace());
            throw e;

        } finally {

            dBeaverConnection.closePrepStatement(preparedStatement);
            dBeaverConnection.closeResultSet(resultSet);


        }
        return allRowsMap;
    }


    public ArrayList<Map> get_Data_From_PROGRAMMINGQUEUE() throws Exception {

        QUERY = "select * FROM eMOVE_TEST.commsrv.PROGRAMMINGQUEUE";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Map> allRowsMap = new ArrayList<Map>();

        try {

            preparedStatement = connection.prepareStatement(QUERY);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Map oneRowMap = new HashMap();


                oneRowMap.put("MUVENDOR", resultSet.getString("MUVENDOR"));

                oneRowMap.put("STATUS", resultSet.getString("STATUS"));

                oneRowMap.put("OUTGOINGMESSAGEID", resultSet.getString("OUTGOINGMESSAGEID"));

                oneRowMap.put("CAUSE", resultSet.getString("CAUSE"));



                allRowsMap.add(oneRowMap);
            }
        } catch (Exception e) {
            System.out.println("Error in THE METHOD get_Data_From_PROGRAMMINGQUEUE");
            System.out.println(e.getStackTrace());
            throw e;

        } finally {

            dBeaverConnection.closePrepStatement(preparedStatement);
            dBeaverConnection.closeResultSet(resultSet);
        }
        return allRowsMap;
    }


    public ArrayList<Map> get_Data_From_PROGRAMMINGQUEUELOG(int MUID) throws Exception {


        QUERY = "select * FROM eMOVE_TEST.commsrv.PROGRAMMINGQUEUELOG where OUTGOINGMESSAGEID IN (SELECT OUTBOUNDID FROM eMOVE_TEST.dbo.OUTBOUNDLOG WHERE MUID = ?) ORDER BY QUEUENUM ASC ";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Map> allRowsMap = new ArrayList<Map>();

        try {

            preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, MUID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Map oneRowMap = new HashMap();

                oneRowMap.put("TIME_STAMP", resultSet.getString("TIME_STAMP"));

                oneRowMap.put("MUVENDOR", resultSet.getString("MUVENDOR"));

                oneRowMap.put("STATUS", resultSet.getString("STATUS"));

                oneRowMap.put("PROGDATA", resultSet.getString("PROGDATA"));

                oneRowMap.put("SENDRETRY", resultSet.getString("SENDRETRY"));

                oneRowMap.put("OUTGOINGMESSAGEID", resultSet.getString("OUTGOINGMESSAGEID"));

                oneRowMap.put("CAUSE", resultSet.getString("CAUSE"));

                oneRowMap.put("POSSIBLEWRONGCOMMAND", resultSet.getString("POSSIBLEWRONGCOMMAND"));


                allRowsMap.add(oneRowMap);


            }


        } catch (Exception e) {
            System.out.println("Error in THE METHOD getInfoFrom_OUTBOUNDLOG");
            System.out.println(e.getStackTrace());
            throw e;

        } finally {

            dBeaverConnection.closePrepStatement(preparedStatement);
            dBeaverConnection.closeResultSet(resultSet);


        }
        return allRowsMap;
    }


    public ArrayList<Map> get_Data_From_MUMONITORINGPROGRAMS(int MUID) throws Exception {

        QUERY = "select * from eMOVE_TEST.dbo.MUMONITORINGPROGRAMS WHERE MUID = ? ORDER BY ASSIGNMENTTIME DESC";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        ArrayList<Map> allRowsMap = new ArrayList<Map>();


        try {

            preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, MUID);


            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Map oneRowMap = new HashMap();

                oneRowMap.put("MUID", resultSet.getString("MUID"));

                oneRowMap.put("TIMEPERIOD", resultSet.getString("TIMEPERIOD"));

                oneRowMap.put("DISTANCEPERIOD", resultSet.getString("DISTANCEPERIOD"));

                oneRowMap.put("MESSAGEPERIOD", resultSet.getString("MESSAGEPERIOD"));

                oneRowMap.put("ANGLE", resultSet.getString("ANGLE"));

                oneRowMap.put("ASSIGNMENTTIME", resultSet.getString("ASSIGNMENTTIME"));

                oneRowMap.put("STATUS", resultSet.getString("STATUS"));

                oneRowMap.put("CAUSE", resultSet.getString("CAUSE"));

                oneRowMap.put("OUTBOUNDID", resultSet.getString("OUTBOUNDID"));


                allRowsMap.add(oneRowMap);

            }


        } catch (Exception e) {
            System.out.println("Error in THE METHOD get_Data_From_MUMONITORINGPROGRAMS");
            System.out.println(e.getStackTrace());
            throw e;

        } finally {

            dBeaverConnection.closePrepStatement(preparedStatement);
            dBeaverConnection.closeResultSet(resultSet);


        }
        return allRowsMap;
    }


    public ArrayList<Map> get_Data_From_MUMONITORINGPROGRAMS_LOG(int MUID) throws Exception {

        QUERY = "select * from eMOVE_TEST.dbo.MUMONITORINGPROGRAMS_LOG WHERE MUID = ? ORDER BY ACTIONTIME ASC";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        ArrayList<Map> allRowsMap = new ArrayList<Map>();


        try {

            preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, MUID);


            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Map oneRowMap = new HashMap();

                oneRowMap.put("MUID", resultSet.getString("MUID"));

                oneRowMap.put("ACTIONTYPE", resultSet.getString("ACTIONTYPE"));

                oneRowMap.put("ACTIONTIME", resultSet.getString("ACTIONTIME"));

                oneRowMap.put("TIMEPERIOD", resultSet.getString("TIMEPERIOD"));

                oneRowMap.put("STATUS", resultSet.getString("STATUS"));

                oneRowMap.put("CAUSE", resultSet.getString("CAUSE"));

                oneRowMap.put("OUTBOUNDID", resultSet.getString("OUTBOUNDID"));

                oneRowMap.put("ACTIONUSERID", resultSet.getString("ACTIONUSERID"));

                allRowsMap.add(oneRowMap);

            }


        } catch (Exception e) {
            System.out.println("Error in THE METHOD get_Data_From_MUMONITORINGPROGRAMS_LOG");
            System.out.println(e.getStackTrace());
            throw e;

        } finally {

            dBeaverConnection.closePrepStatement(preparedStatement);
            dBeaverConnection.closeResultSet(resultSet);


        }
        return allRowsMap;
    }


    //region DELETE METHODS

    public int delete_Data_From_OUTBOUND(int MUID) throws Exception {

        QUERY = "DELETE FROM eMOVE_TEST.dbo.OUTBOUND WHERE MUID = ?";

        PreparedStatement preparedStatement = null;
        int HowManyRowDeleted;

        try {

            preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setInt(1, MUID);

            HowManyRowDeleted = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error in THE METHOD delete_Data_From_OUTBOUND");
            System.out.println(e.getStackTrace());
            throw e;

        } finally {

            dBeaverConnection.closePrepStatement(preparedStatement);
        }

        return HowManyRowDeleted;
    }

    public int delete_Data_From_OUTBOUNDLOG(int MUID) throws Exception {

        QUERY = "DELETE FROM eMOVE_TEST.dbo.OUTBOUNDLOG WHERE MUID = ?";

        PreparedStatement preparedStatement = null;
        int HowManyRowDeleted;

        try {

            preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setInt(1, MUID);

            HowManyRowDeleted = preparedStatement.executeUpdate();


        } catch (Exception e) {
            System.out.println("Error in THE METHOD delete_Data_From_OUTBOUNDLOG");
            System.out.println(e.getStackTrace());
            throw e;

        } finally {

            dBeaverConnection.closePrepStatement(preparedStatement);
        }

        return HowManyRowDeleted;
    }

    public int delete_Data_From_PROGRAMMINGQUEUE() throws Exception {

        QUERY = "DELETE FROM eMOVE_TEST.commsrv.PROGRAMMINGQUEUE";

        PreparedStatement preparedStatement = null;
        int howManyRowDeleted;

        try {

            preparedStatement = connection.prepareStatement(QUERY);

            howManyRowDeleted = preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error in THE METHOD delete_Data_From_PROGRAMMINGQUEUE");
            System.out.println(e.getStackTrace());
            throw e;

        } finally {

            dBeaverConnection.closePrepStatement(preparedStatement);
        }

        return howManyRowDeleted;
    }

    public int delete_Data_From_PROGRAMMINGQUEUE_LOG(int OUTGOINGMESSAGEID) throws Exception {

        QUERY = "DELETE FROM eMOVE_TEST.commsrv.PROGRAMMINGQUEUELOG where OUTGOINGMESSAGEID = ?";

        PreparedStatement preparedStatement = null;
        int howManyRowDeleted = 0;

        try {

            preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setInt(1, OUTGOINGMESSAGEID);

            howManyRowDeleted = preparedStatement.executeUpdate();


        } catch (Exception e) {
            System.out.println("Error in THE METHOD delete_Data_From_PROGRAMMINGQUEUELOG");
            System.out.println(e.getStackTrace());
            throw e;

        } finally {

            dBeaverConnection.closePrepStatement(preparedStatement);
        }

        return howManyRowDeleted;
    }

    public int delete_Data_From_MUMONITORINGPROGRAMS(int MUID) throws Exception {

        QUERY = "DELETE FROM eMOVE_TEST.dbo.MUMONITORINGPROGRAMS where MUID = ?";

        PreparedStatement preparedStatement = null;
        int howManyRowDeleted = 0;

        try {

            preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setInt(1, MUID);

            howManyRowDeleted = preparedStatement.executeUpdate();


        } catch (Exception e) {
            System.out.println("Error in THE METHOD delete_Data_From_MUMONITORINGPROGRAMS");
            System.out.println(e.getStackTrace());
            throw e;

        } finally {

            dBeaverConnection.closePrepStatement(preparedStatement);
        }

        return howManyRowDeleted;
    }

    public int delete_Data_From_MUMONITORINGPROGRAMS_LOG(int MUID) throws Exception {

        QUERY = "DELETE FROM eMOVE_TEST.dbo.MUMONITORINGPROGRAMS_LOG where MUID = ?";

        PreparedStatement preparedStatement = null;
        int howManyRowDeleted = 0;

        try {

            preparedStatement = connection.prepareStatement(QUERY);

            preparedStatement.setInt(1, MUID);

            howManyRowDeleted = preparedStatement.executeUpdate();


        } catch (Exception e) {
            System.out.println("Error in THE METHOD delete_Data_From_MUMONITORINGPROGRAMS_LOG");
            System.out.println(e.getStackTrace());
            throw e;

        } finally {

            dBeaverConnection.closePrepStatement(preparedStatement);
        }

        return howManyRowDeleted;
    }

    //endregion


}
