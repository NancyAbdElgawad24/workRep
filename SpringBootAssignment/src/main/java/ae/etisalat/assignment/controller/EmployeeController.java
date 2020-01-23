package ae.etisalat.assignment.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.etisalat.core.ApplicationFacade;
import com.etisalat.core.constants.Constants;
import com.etisalat.core.models.EmployeeModel;
import com.etisalat.core.utils.GeneralException;

//import ae.etisalat.assignment.beans.EmployeeModel;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@RequestMapping(method = RequestMethod.POST, value = "/getEmployeeListIndex")
	@ResponseBody
	public ResponseEntity<List<EmployeeModel>> getEmployeeList(@RequestBody String jsonString) {
		List<EmployeeModel> outList = new ArrayList<EmployeeModel>();
		try {
			JSONObject object = new JSONObject(jsonString);

			ApplicationFacade facade = new ApplicationFacade();
			Hashtable<String, String> criteria = new Hashtable<String, String>();
			criteria.put(Constants.FIRST_INDEX, object.getString(Constants.FIRST_INDEX));
			criteria.put(Constants.MAX_INDEX, object.getString(Constants.MAX_INDEX));
			outList = facade.retrieveEmployeesList(criteria);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GeneralException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<List<EmployeeModel>>(outList, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getEmployeeList")
	@ResponseBody
	public ResponseEntity<List<EmployeeModel>> getAllEmployee() {
		List<EmployeeModel> outList = new ArrayList<EmployeeModel>();
		try {

			ApplicationFacade facade = new ApplicationFacade();
			Hashtable<String, String> criteria = new Hashtable<String, String>();
			criteria.put(Constants.FIRST_INDEX, "0");
			criteria.put(Constants.MAX_INDEX, "100");
			outList = facade.retrieveEmployeesList(criteria);
		} catch (GeneralException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<List<EmployeeModel>>(outList, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping("/addEmployee")
	@PostMapping
	public ResponseEntity<Long> addEmployee(@RequestBody EmployeeModel empInput) {
		ApplicationFacade facade = new ApplicationFacade();
		Long empId = null;
		try {
			empId = facade.addEmployee(empInput);
		} catch (GeneralException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<Long>(empId, new HttpHeaders(), HttpStatus.OK);

	}

	@RequestMapping("/deleteEmployee")
	@PostMapping
	public ResponseEntity<Void> deleteEmployee(@RequestBody Long employeeId) {
		ApplicationFacade facade = new ApplicationFacade();
		try {
			EmployeeModel model = new EmployeeModel();
			model.setEmployeeId(employeeId);
			facade.deleteEmployee(model);
		} catch (GeneralException e) {
			return new ResponseEntity<Void>( new HttpHeaders(), HttpStatus.FAILED_DEPENDENCY);
		}

		return new ResponseEntity<Void>( new HttpHeaders(), HttpStatus.OK);
	}

}
