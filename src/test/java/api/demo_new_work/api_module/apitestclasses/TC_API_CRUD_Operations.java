package api.demo_new_work.api_module.apitestclasses;

import com.restassured.services.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;import com.utilities.BaseClass;
import com.utilities.ConfigFilesUtility;
import api.demo_new_work.api_module.apipageclasses.POST_Operartion_restDataset;
import api.demo_new_work.api_module.apipageclasses.GET_Operation_Rest_IDDataset;
import api.demo_new_work.api_module.apipageclasses.GET_OperationRestAPIDataset;
public class TC_API_CRUD_Operations extends BaseClass {

	private Logger logger;
	private ConfigFilesUtility configFileObj;

	public TC_API_CRUD_Operations() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger(TC_API_CRUD_Operations.class);
		configFileObj= new ConfigFilesUtility();
		configFileObj.loadPropertyFile("TC_API_CRUD_Operations.properties");
	}

	@Test(priority = 1)
	public void doRequest() throws Exception { 
	
		for(int i = 1; i <= configFileObj.getIntProperty("datasetsLength"); i++) {
			boolean isExecutionFlag = true;			
		/*--------------------- POST --------------------- */

			if(isExecutionFlag) {
 			 	Object object = (Object) new POST_Operartion_restDataset();
				Class<?> c = object.getClass();
				String urlParams = (String) c.getField("urlParams" + i).get(object);
				if(urlParams == null) return;
				String headers = (String) c.getField("headers" + i).get(object);
				String body = (String) c.getField("body" + i).get(object);
				String datasetResources = (String) c.getField("datasetResources" + i).get(object);
				int reqType = (Integer) c.getField("requestType" + i).get(object);
				int bodyType = (Integer) c.getField("bodyType" + i).get(object);
				String response = APIService.callRequest(configFileObj, urlParams, headers, reqType, bodyType, body, configFileObj.getProperty("dataset" +i), datasetResources, logger);
			}

		/*--------------------- GET --------------------- */

			if(isExecutionFlag) {
 			 	Object object = (Object) new GET_Operation_Rest_IDDataset();
				Class<?> c = object.getClass();
				String urlParams = (String) c.getField("urlParams" + i).get(object);
				if(urlParams == null) return;
				String headers = (String) c.getField("headers" + i).get(object);
				String body = (String) c.getField("body" + i).get(object);
				String datasetResources = (String) c.getField("datasetResources" + i).get(object);
				int reqType = (Integer) c.getField("requestType" + i).get(object);
				int bodyType = (Integer) c.getField("bodyType" + i).get(object);
				String response = APIService.callRequest(configFileObj, urlParams, headers, reqType, bodyType, body, configFileObj.getProperty("dataset" +i), datasetResources, logger);
			}

		/*--------------------- GET --------------------- */

			if(isExecutionFlag) {
 			 	Object object = (Object) new GET_OperationRestAPIDataset();
				Class<?> c = object.getClass();
				String urlParams = (String) c.getField("urlParams" + i).get(object);
				if(urlParams == null) return;
				String headers = (String) c.getField("headers" + i).get(object);
				String body = (String) c.getField("body" + i).get(object);
				String datasetResources = (String) c.getField("datasetResources" + i).get(object);
				int reqType = (Integer) c.getField("requestType" + i).get(object);
				int bodyType = (Integer) c.getField("bodyType" + i).get(object);
				String response = APIService.callRequest(configFileObj, urlParams, headers, reqType, bodyType, body, configFileObj.getProperty("dataset" +i), datasetResources, logger);
			}
		}
	}}
