import React, { useState } from 'react'
import {getEmployee} from '../service/EmployeeService'

export default function EmployeeComponent() {

    const [employee,setEmployee] = useState({})
    const [department,setDepartment] = useState({})
    const [organization,setOrganization] = useState({})

    useEffect(()=>{
        getEmployee.then((res)=>{
            setEmployee(res.data.employee)
            setDepartment(res.data.department)
            setOrganization(res.data.organization)
        })
    },[])

  return (
    <div>EmployeeComponent</div>
  )
}
