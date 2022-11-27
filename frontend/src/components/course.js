import React, { useEffect,useState } from 'react'
import axios from "axios";

const MyForm = ({ enterCourse }) =>  {

  // States for tracking form input which are the email address and password
  const [ course_code, setCoursecode ] = useState('')
  const [ name, setName ] = useState('')
  const [ description, setDescription ] = useState('')
  const [ year, setYear ] = useState('')
  const [ term, setTerm ] = useState('')
  const [ credits, setCredits ] = useState('')
  const [ capacity, setCapacity ] = useState('')
  const [ specialisation, setspecialisation ] = useState('');
  const [ selectedPrerequisite, setSelectedPrerequisite] = useState([]);
  const [ selectedPrerequisiteId, setSelectedPrerequisiteId] = useState([]);
  const [ savedSpecialisationList, setSavedSpecialisationList] = useState([]);
  const [ savedCourseList, setSavedCourseList] = useState([]);

  

  async function getSpecialisations(){
    await axios.get("http://localhost:8080/billPayment-1.0-SNAPSHOT/api/courses/getSpecialisation", {})
        .then(
            (response) => {
                console.log(response);
                if(response.status === 200){
                    setSavedSpecialisationList(response.data);
                }
            },
            (error) => {
                console.log(error);
            }
        );
}
async function getCourses(){
    await axios.get("http://localhost:8080/ESD_Project-1.0-SNAPSHOT/api/course/getCourses", {})
        .then(
            (response) => {
                console.log(response);
                if(response.status === 200){
                    setSavedCourseList(response.data);
                }
            },
            (error) => {
                console.log(error);
            }
        );
}
getSpecialisations();
getCourses();


const handlespecialisation = (event) => {
  setspecialisation(event.target.value);
}

  // onSubmit event handler of this form
  const handleCourse = (event) => {
    // Preventing default submission of the form to the action attribute URL
    event.preventDefault()

    const courseObject = {
      course_code,name,description,year,term,credits,capacity,specialisation:{specialisationId:specialisation}
    }

    // Calling startLogin with the provided credentials that will make a call to the backend
    enterCourse(courseObject)

    // Reset the form state, i.e. the text that's on the username and password text boxes to empty strings
    setCapacity('')
    setCoursecode('')
    setCredits('')
    setDescription('')
    setName('')
    setCapacity('')
    setTerm('')
    setYear('')
    setspecialisation("")
    setSelectedPrerequisite([])
  }

  return (

    

    <form onSubmit={handleCourse}>
      <label>Enter course code:
      <input 
        type="text" 
        name="course_code" 
        value={course_code} 
        onChange={event => setCoursecode(event.target.value)}
      />
      </label>
      
      <label>Enter course name:
      <input 
        type="text" 
        name="name" 
        value={name} 
        onChange={event => setName(event.target.value)}
      />
      </label>

      <label>Enter course description:
      <input 
        type="text" 
        name="description" 
        value={description} 
        onChange={event => setDescription(event.target.value)}
      />
      </label>

      <label>Enter course year:
      <input 
        type="text" 
        name="year" 
        value={year} 
        onChange={event => setYear(event.target.value)}
      />
      </label>

      <label>Enter course term:
      <input 
        type="text" 
        name="term" 
        value={term} 
        onChange={event => setTerm(event.target.value)}
      />
      </label>

      <label>Enter course credits:
      <input 
        type="number" 
        name="credits" 
        value={credits} 
        onChange={event => setCredits(event.target.value)}
      />
      </label>

      <label>Enter course capacity:
        <input 
          type="number" 
          name="capacity" 
          value={capacity} 
          onChange={event => setCapacity(event.target.value)}
        />
        </label>
        
        <input type="submit" />
    </form>
  )
}

export default MyForm