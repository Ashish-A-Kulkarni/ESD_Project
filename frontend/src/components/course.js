import React, { useEffect,useState } from 'react'
// import Multiselect from 'multiselect-react-dropdown'

// import axios from "axios";

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
  const [ prerequisites, setPrerequisite] = useState('');
  const [ prerequisiteList, setprerequisiteList] = useState([]);
  const [specialisationList,setspecialisationList]=useState([]);

  useEffect(() =>{
    const fetchData = async ()=>{
        const response = await fetch(`http://localhost:8080/billPayment-1.0-SNAPSHOT/api/courses/getSpecialisation`);
        const newData = await response.json();
        console.log("");
        setspecialisationList(newData);
        // console.log(newData);
    };
    fetchData();
}, [])

useEffect(() =>{
  const fetchData = async ()=>{
      const response = await fetch(`http://localhost:8080/billPayment-1.0-SNAPSHOT/api/courses/get_all`);
      const newData = await response.json();
      console.log("");
      setprerequisiteList(newData);
      console.log(newData);
  };
  fetchData();
}, [])



const handlespecialisation = (event) => {
  setspecialisation(event.target.value);
  console.log(specialisation)
}

const handlePrerequisite = (event) => {
  setPrerequisite(event.target.value);
  console.log(prerequisites)

}
  // onSubmit event handler of this form
  const handleCourse = (event) => {
    // Preventing default submission of the form to the action attribute URL
    event.preventDefault()

    const courseObject = {
      course_code,name,description,year,term,credits,capacity,specialisation:{specialisation_id:specialisation},prerequisites:([{course_id:prerequisites}])
    }

    console.log(courseObject)
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
    setPrerequisite("")
  }

  return (

  
    <div className='form-container'>
    <div className='form-box regular-shadow'>

    <br></br>
    <br></br>    

    <form onSubmit={handleCourse}>

      <table align='center' textalign='center'>

       <tr> 
        
        <label>Enter course code:
      <input 
        type="text" 
        name="course_code" 
        value={course_code} 
        onChange={event => setCoursecode(event.target.value)}
      />
      </label>
      
      </tr>
      <tr>
      <label>Enter course name:
      <input 
        type="text" 
        name="name" 
        value={name} 
        onChange={event => setName(event.target.value)}
      />
      </label>
      </tr>
      <tr>
      <label>Enter course description:
      <input 
        type="text" 
        name="description" 
        value={description} 
        onChange={event => setDescription(event.target.value)}
      />
      </label>
      </tr>
      <tr>
      <label>Enter course year:
      <input 
        type="text" 
        name="year" 
        value={year} 
        onChange={event => setYear(event.target.value)}
      />
      </label>
      </tr>
      <tr>
      <label>Enter course term:
      <input 
        type="text" 
        name="term" 
        value={term} 
        onChange={event => setTerm(event.target.value)}
      />
      </label>
      </tr>
      <tr>
      <label>Enter course credits:
      <input 
        type="number" 
        name="credits" 
        value={credits} 
        onChange={event => setCredits(event.target.value)}
      />
      </label>
      </tr>
      <tr>
      <label>Enter course capacity:
        <input 
          type="number" 
          name="capacity" 
          value={capacity} 
          onChange={event => setCapacity(event.target.value)}
        />
        </label>
        </tr>
        <tr>
            <label className="form__label" for="Specialisation">Specialisation </label>
            <select className="form-control" value={specialisation} onChange={handlespecialisation}>
                    <option value="">Select Specialisation</option>
                    {/* <option>Faculty</option> */}

                             {specialisationList.map(specialisation => (
                                <option value={specialisation.specialisation_id} key={specialisation.specialisation_id} >{specialisation.name}</option>
                                ))
                            } 

            </select>
          </tr>
          <tr>
            <label className="form__label" for="Prerequisite">Prerequisute </label>
            <select className="form-control" value={prerequisites} onChange={handlePrerequisite}>
                    <option value="">Select Prerequisite</option>
                    {/* <option>Faculty</option> */}

                             {prerequisiteList.map(prerequisites => (
                                <option value={prerequisites.course_id} key={prerequisites.course_id} > {prerequisites.name}</option>
                                ))
                            } 

          
            </select>        

            </tr>
            <tr>
              <br></br>
        <input type="submit" />
        </tr>
        </table>
        <br></br>
    <br></br>
    </form>
    </div>
    </div>
  )
}

export default MyForm