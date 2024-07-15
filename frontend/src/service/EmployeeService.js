import axios from 'axios'

const EMPLOYEE_SERVICE_BASE_URL = 'http://localhost:9191/api/employees'

const EMPLOYEE_ID = 2;

export const getEmployee = async ()=>{
       let response = await axios.get(EMPLOYEE_SERVICE_BASE_URL+'/'+EMPLOYEE_ID)
       return response.data;
    }


