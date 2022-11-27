import { useState } from 'react'

import loginService from './services/login'
import courseService from './services/course'

import Notification from './components/Notification'
import LoginForm from './components/LoginForm'
import NavBar from './components/NavBar'
import MyForm from './components/course'

const App = () => {
  // user state will store the logged in user object, if no login has been done yet then it will be null
  const [ user, setUser ] = useState(null)

  // Will store the bills of the logged in user

  // These states are used to control the notifications that show up at the top of the screen for events like 
  // login, signup, watchlist creation, etc.
  const [ notification, setNotification ] = useState(null)
  const [ notificationType, setNotificationType ] = useState(null)

  // Create a notification at the top of the screen with given message for 10 seconds 
  // Notifications are of two types, "error" and "success"
  // The appearance of these two notifications can be adjusted via the index.css file
  const notificationHandler = (message, type) => {
    setNotification(message)
    setNotificationType(type)

    setTimeout(() => {
      setNotificationType(null)
      setNotification(null)
    }, 3000)
  }

  // Function that handles login of users
  const handleLogin = async (credentials) => {
    try {
      const userObject = await loginService.login(credentials)
      setUser(userObject)
      window.localStorage.setItem('loggedInUser', JSON.stringify(userObject))
      
      notificationHandler(`Logged in successfully as ${userObject.first_name}`, 'success')
      //setBills([])
    }
    catch (exception) {
      notificationHandler(`Log in failed, check username and password entered`, 'error')
    }
  }


  const handleCourse = async (courseObject) => {
    try {
      
      await courseService.createCourse(courseObject)

      notificationHandler('Course Created successfully','success')
    }
    catch (exception) {
      notificationHandler(`Course Creation Failed`, 'error')
    }
  }
  // Function that pays a bill using the billObject that is passed to the function
  

  
  // Effect Hook that fetches a user's bills
  // If "user" state changes, then the new bills must be fetched.
  // This is why "user" is part of the dependency array of this hook
  // MIGHT HAVE TO CHANGE THIS LATER TO PROMISE CHAINING IF IT FAILS



  // Effect Hook that parses the local storage for 'loggedInUser' and sets the "user" state if a valid match is found
  // This enables user to login automatically without having to type in the credentials. Caching the login if you will.
  // useEffect(() => {
  //   const loggedInUser = window.localStorage.getItem('loggedInUser')
  //   if (loggedInUser)
  //     setUser(JSON.parse(loggedInUser))
  // }, [])

  return (
    <div>
      {/* Header of the page */}
      <div className='text-center page-header p-2 regular-text-shadow regular-shadow'>
          <div className='display-4 font-weight-bold'>
            Academia
          </div>
      </div>
      
      {/* Notification component that will render only when the notification state is not null */}
      <Notification notification={notification} type={notificationType} />

      {
        /* Show Login form when no login has happened */
        user === null && 
        <LoginForm startLogin={handleLogin}/>
      }

      {
        /* Show NavBar when login has happened */
        user !== null && 
        <NavBar user={user} setUser={setUser}/>
      } 

      {
        user!=null &&
        <MyForm enterCourse={handleCourse}/>
      }
      
    </div>
  )
}

export default App;
