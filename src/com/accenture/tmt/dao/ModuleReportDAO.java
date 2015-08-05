package com.accenture.tmt.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.common.DBConnection;
import com.accenture.tmt.dao.dto.ModuleDetailsDTO;
import com.accenture.tmt.dao.dto.ModuleDetailsFlatDTO;
import com.accenture.tmt.dao.dto.ModuleReportFlatDTO;
import com.accenture.tmt.presentation.dto.ModuleReportDTO;
import com.accenture.tmt.presentation.dto.ModuleReportUpdateDTO;

public class ModuleReportDAO {
	public void insertModuleReport(ModuleReportUpdateDTO reportupdatedto){
		
		
			
				try {
					Connection con = DBConnection.getConnection();
					if(con != null){
						
					    PreparedStatement st1 = con.prepareStatement(CONSTANTS.INSERT_MODULE_REPORT_QUERY);
						    st1. setString(1,reportupdatedto.getModuleName());
						    st1. setString(2,reportupdatedto.getProjectId());
						    st1. setString(3,reportupdatedto.getModuleId());
						    st1. setString(4,reportupdatedto.getModuleDescription());
						    st1. setString(5,reportupdatedto.getUserName());
						    st1. setString(6,reportupdatedto.getAction());
						    st1. setString(7,reportupdatedto.getTimeStamp());
						    st1. setDate(8,reportupdatedto.getDates());
						
							  st1.executeUpdate();
							  
							
}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
}
	
	
	
	
public List<String> getModuleList(){
		
		List<String> moduleList = new ArrayList<String>();
		ResultSet rs = null ;
		try {
			Connection con = DBConnection.getConnection();
			if (con != null) {
				PreparedStatement st = con
					  .prepareStatement(CONSTANTS.GET_MODULE_LIST_QUERY);
				rs = st.executeQuery();
				while(rs.next()){
						  moduleList.add(rs.getString("ModuleName"));
				 }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moduleList;
		
	}


public List<ModuleReportFlatDTO> getDetailsWithoutAnything(ModuleReportDTO modulereportdto){
	List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
	ModuleReportFlatDTO moduleList = null;
         try {
			ResultSet rs = null;
			 Connection con = DBConnection.getConnection();
				if(con != null){
				    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_MODULE_REPORT);
				  rs = st1.executeQuery();
				  resultSet(rs,(ArrayList<ModuleReportFlatDTO>) modulereportflatdto);
				   
				    con.close();
					}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return modulereportflatdto;
}
public List<ModuleReportFlatDTO> getDetailsWithoutModuleNameDAO(ModuleReportDTO modulereportdto){
	List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
	
         try {
			ResultSet rs = null;
			 Connection con = DBConnection.getConnection();
				if(con != null){
				    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_REPORT_DETAIL_WITHOUT_MODULE_NAME_QUERY);
				    System.out.println(modulereportdto.getStartDate());
				    
				    
				   
				    st1.setDate(1, (Date) (modulereportdto.getStartDate()));
				    
				    st1.setDate(2, (Date) (modulereportdto.getEndDate()));
				    rs = st1.executeQuery();
			resultSet(rs,(ArrayList<ModuleReportFlatDTO>) modulereportflatdto);
				   
				    con.close();
					}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return modulereportflatdto;
}
public List<ModuleReportFlatDTO> getDetailsWithoutModuleName_With_Action(ModuleReportDTO modulereportdto){
	List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
	ModuleReportFlatDTO moduleList = null;
         try {
			ResultSet rs = null;
			 Connection con = DBConnection.getConnection();
				if(con != null){
				    PreparedStatement st1 = con.prepareStatement(CONSTANTS. GET_REPORT_DETAIL_WITHOUT_MODULE_NAME_QUERY_WITH_ACTION);
				    System.out.println(modulereportdto.getStartDate());
				    
				    
				    
				 
				    st1.setDate(1, (Date) (modulereportdto.getStartDate()));
				    
				    st1.setDate(2, (Date) (modulereportdto.getEndDate()));
				    st1.setString(3, modulereportdto.getAction());
				    
				    rs = st1.executeQuery();
				    resultSet(rs,(ArrayList<ModuleReportFlatDTO>) modulereportflatdto);
				   
				    con.close();
					}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return modulereportflatdto;
}


public List<ModuleReportFlatDTO> getDetailsWithoutStartDateDAO(ModuleReportDTO modulereportdto){
	
	List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
	ModuleReportFlatDTO moduleList = null;
         try {
			ResultSet rs = null;
			 Connection con = DBConnection.getConnection();
				if(con != null){
				    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_REPORT_DETAIL_WITHOUT_START_DATE_QUERY);
				    st1.setString(1, modulereportdto.getModuleName());
				    st1.setDate(2, (Date) modulereportdto.getEndDate());
				    rs = st1.executeQuery();
				    resultSet(rs,(ArrayList<ModuleReportFlatDTO>) modulereportflatdto);
				    con.close();
					}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return modulereportflatdto;

}
public List<ModuleReportFlatDTO> getDetailsWithoutStartDate_With_Action(ModuleReportDTO modulereportdto){
	
	List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
	ModuleReportFlatDTO moduleList = null;
         try {
			ResultSet rs = null;
			 Connection con = DBConnection.getConnection();
				if(con != null){
				    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_REPORT_DETAIL_WITHOUT_START_DATE_QUERY_WITH_ACTION );
				    st1.setString(1, modulereportdto.getModuleName());
				    st1.setDate(2, (Date) modulereportdto.getEndDate());
				    st1.setString(3, modulereportdto.getAction());
				    rs = st1.executeQuery();
				    resultSet(rs,(ArrayList<ModuleReportFlatDTO>) modulereportflatdto);
				    con.close();
					}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return modulereportflatdto;

}
public List<ModuleReportFlatDTO> getDetailsWithoutEndDateDAO(ModuleReportDTO modulereportdto){
	List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
	ModuleReportFlatDTO moduleList = null;
    try {
		ResultSet rs = null;
		 Connection con = DBConnection.getConnection();
			if(con != null){
			    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_REPORT_DETAIL_WITHOUT_END_DATE_QUERY);
			    st1.setString(1, modulereportdto.getModuleName());
			    st1.setDate(2, (Date) modulereportdto.getStartDate());
			    rs = st1.executeQuery();
			    resultSet(rs,(ArrayList<ModuleReportFlatDTO>) modulereportflatdto);
			    con.close();
				}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return modulereportflatdto;

}
public List<ModuleReportFlatDTO> getDetailsWithoutEndDateDAO_With_Action(ModuleReportDTO modulereportdto){
	List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
	ModuleReportFlatDTO moduleList = null;
    try {
		ResultSet rs = null;
		 Connection con = DBConnection.getConnection();
			if(con != null){
			    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_REPORT_DETAIL_WITHOUT_END_DATE_QUERY_WITH_ACTION);
			    st1.setString(1, modulereportdto.getModuleName());
			    st1.setDate(2, (Date) modulereportdto.getStartDate());
			    st1.setString(3, modulereportdto.getAction());
			    rs = st1.executeQuery();
			    resultSet(rs,(ArrayList<ModuleReportFlatDTO>) modulereportflatdto);
			    con.close();
				}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return modulereportflatdto;

}
public List<ModuleReportFlatDTO> getDetailsEndDate_With_Action(ModuleReportDTO modulereportdto){
	List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
	ModuleReportFlatDTO moduleList = null;
    try {
		ResultSet rs = null;
		 Connection con = DBConnection.getConnection();
			if(con != null){
			    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_REPORT_DETAIL_WITH_END_DATE_ACTION );
			   
			    st1.setDate(1, (Date) modulereportdto.getEndDate());
			    st1.setString(2, modulereportdto.getAction());
			    rs = st1.executeQuery();
			    resultSet(rs,(ArrayList<ModuleReportFlatDTO>) modulereportflatdto);
			    con.close();
				}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return modulereportflatdto;

}
public List<ModuleReportFlatDTO> getDetailsModuleName_With_Action(ModuleReportDTO modulereportdto){
	List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
	ModuleReportFlatDTO moduleList = null;
    try {
		ResultSet rs = null;
		 Connection con = DBConnection.getConnection();
			if(con != null){
			    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_REPORT_DETAIL_WITH_MODULENAME_ACTION );
			   
			    st1.setDate(1, (Date) modulereportdto.getEndDate());
			    st1.setString(2, modulereportdto.getAction());
			    rs = st1.executeQuery();
			    resultSet(rs,(ArrayList<ModuleReportFlatDTO>) modulereportflatdto);
			    con.close();
				}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return modulereportflatdto;

}
public List<ModuleReportFlatDTO> getDetailsStartDate_With_Action(ModuleReportDTO modulereportdto){
	List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
	ModuleReportFlatDTO moduleList = null;
    try {
		ResultSet rs = null;
		 Connection con = DBConnection.getConnection();
			if(con != null){
			    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_REPORT_DETAIL_WITH_START_DATE_ACTION );
			   
			    st1.setDate(1, (Date) modulereportdto.getStartDate());
			    st1.setString(2, modulereportdto.getAction());
			    rs = st1.executeQuery();
			    resultSet(rs,(ArrayList<ModuleReportFlatDTO>) modulereportflatdto);
			    con.close();
				}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return modulereportflatdto;

}

public List<ModuleReportFlatDTO> getDetailsWithOnlyEndDateDAO(ModuleReportDTO modulereportdto){
	List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
	ModuleReportFlatDTO moduleList = null;
    try {
		ResultSet rs = null;
		 Connection con = DBConnection.getConnection();
			if(con != null){
			    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_REPORT_DETAIL_WITH_ONLY_END_DATE_QUERY);
			    st1.setDate(1, (Date)modulereportdto.getEndDate());
			    rs = st1.executeQuery();
			    resultSet(rs,(ArrayList<ModuleReportFlatDTO>) modulereportflatdto);
			    con.close();
				}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return modulereportflatdto;
	
}
public List<ModuleReportFlatDTO> getDetailsWithOnlyModuleNameDAO(ModuleReportDTO modulereportdto){
	List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
	ModuleReportFlatDTO moduleList = null;
    try {
		ResultSet rs = null;
		 Connection con = DBConnection.getConnection();
			if(con != null){
			    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_REPORT_DETAIL_WITH_ONLY_MODULE_NAME_QUERY);
			    st1.setString(1, modulereportdto.getModuleName());
			    rs = st1.executeQuery();
			    resultSet(rs,(ArrayList<ModuleReportFlatDTO>) modulereportflatdto);
			    con.close();
				}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return modulereportflatdto;
}
public List<ModuleReportFlatDTO> getDetailsWithOnlyAction(ModuleReportDTO modulereportdto){
	List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
	ModuleReportFlatDTO moduleList = null;
    try {
		ResultSet rs = null;
		 Connection con = DBConnection.getConnection();
			if(con != null){
			    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_REPORT_DETAIL_WITH_ONLY_ACTION);
			    st1.setString(1, modulereportdto.getAction());
			    rs = st1.executeQuery();
			    resultSet(rs,(ArrayList<ModuleReportFlatDTO>) modulereportflatdto);
			    con.close();
				}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return modulereportflatdto;
}
public List<ModuleReportFlatDTO> getDetailsWithOnlyStartDateDAO(ModuleReportDTO modulereportdto){
	List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
	ModuleReportFlatDTO moduleList = null;
    try {
		ResultSet rs = null;
		 Connection con = DBConnection.getConnection();
			if(con != null){
			    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_REPORT_DETAIL_WITH_ONLY_START_DATE_QUERY);
			    st1.setDate(1, (Date) modulereportdto.getStartDate());
			    rs = st1.executeQuery();
			    resultSet(rs,(ArrayList<ModuleReportFlatDTO>) modulereportflatdto);
			    con.close();
				}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return modulereportflatdto;
}
public List<ModuleReportFlatDTO> getDetailsReportDAO(ModuleReportDTO modulereportdto){
	List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
	ModuleReportFlatDTO moduleList = null;
    try {
		ResultSet rs = null;
		 Connection con = DBConnection.getConnection();
			if(con != null){
			    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_REPORT_DETAIL_QUERY);
			    st1.setString(1, modulereportdto.getModuleName());
			    st1.setDate(2, (Date)modulereportdto.getStartDate());
			    st1.setDate(3, (Date)modulereportdto.getEndDate());
			    rs = st1.executeQuery();
			    resultSet(rs,(ArrayList<ModuleReportFlatDTO>) modulereportflatdto);
			    con.close();
				}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return modulereportflatdto;
}
public List<ModuleReportFlatDTO> getDetailsReportDAOWithAction(ModuleReportDTO modulereportdto){
	List<ModuleReportFlatDTO> modulereportflatdto = new ArrayList<ModuleReportFlatDTO>();
	ModuleReportFlatDTO moduleList = null;
    try {
		ResultSet rs = null;
		 Connection con = DBConnection.getConnection();
			if(con != null){
			    PreparedStatement st1 = con.prepareStatement(CONSTANTS.GET_REPORT_DETAIL_QUERY_WITH_ACTION);
			    st1.setString(1, modulereportdto.getModuleName());
			    st1.setDate(2, (Date)modulereportdto.getStartDate());
			    st1.setDate(3, (Date)modulereportdto.getEndDate());
			    st1.setString(4, modulereportdto.getAction());
			    rs = st1.executeQuery();
			    resultSet(rs,(ArrayList<ModuleReportFlatDTO>) modulereportflatdto);
			    con.close();
				}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return modulereportflatdto;
}
 private void resultSet(ResultSet rs,ArrayList<ModuleReportFlatDTO> modulereportflatdto){
	
	 ModuleReportFlatDTO moduleList = null; 
	 try {
		while (rs.next() == true) {
		    	moduleList = new ModuleReportFlatDTO();
		    	moduleList.setModuleName(rs.getString(CONSTANTS.GET_MODULE_NAME));
		    	moduleList.setProjectId(rs.getString(CONSTANTS.GET_PROJECT_ID));
		    	moduleList.setModuleId(rs.getString(CONSTANTS.GET_MODULE_ID));
		    	moduleList.setModuleDescription(rs.getString(CONSTANTS.MODULE_DESCRIPTION));
		    	moduleList.setUserName(rs.getString(CONSTANTS.GET_USER_NAME));
		    	moduleList.setAction(rs.getString(CONSTANTS.GET_ACTION));
		    	moduleList.setTimeStamp(rs.getString(CONSTANTS.GET_TIMESTAMP));
		    	//System.out.println(rs.getString(CONSTANTS.GET_TIMESTAMP));
		    	modulereportflatdto.add(moduleList); 
 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}
