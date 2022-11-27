import axios from 'axios'

// The API endpoint where bills are located
const specurl = 'http://localhost:8080/billPayment-1.0-SNAPSHOT/api/courses/getSpecialisation'

const prequrl = 'http://localhost:8080/billPayment-1.0-SNAPSHOT/api/courses/get_all'
// Gets all bills which belong to a user
const getSpecialisation = async (specObject) => {
  // Send the login credential data to the loginBaseUrl API endpoint as an HTTP POST request
  // Note the async-await
  const response = await axios.get(specurl, specObject)
  
  // Return .data field of the response object which would contain the logged in user object
  // And the user state would now be updated by the handleLogin() method
  return response.data
}


const getPrerequisite = async (preqObject) => {
  // Send the login credential data to the loginBaseUrl API endpoint as an HTTP POST request
  // Note the async-await
  const response = await axios.get(prequrl, preqObject)
  
  // Return .data field of the response object which would contain the logged in user object
  // And the user state would now be updated by the handleLogin() method
  return response.data
}

// Pays the bill which is specified, after paying, the record of the bill is deleted
// So this translates to a delete request from axios to the bill API endpoint at the backend

const exportObject = { getSpecialisation, getPrerequisite}

export default exportObject