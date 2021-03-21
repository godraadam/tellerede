import LoginForm from "./components/LoginForm"
import {useState} from 'react'
import {loginCall} from './service/UserService'
import AdminPage from "./components/AdminPage"


const App = () => {

  const [userDetails, setUserDetails] = useState({username:"", password:"", role:""})
  const [error, setError] = useState("")

  const login = async (details) => {
    if (details.username =="") {
      setError("Please enter your username!")
      return
    }
    if (details.password =="") {
      setError("Please enter your password!")
      return
    }

    const [data, status] = await loginCall(details)
    switch(status) {
      case 401:
        setError("Incorrect password!")
        break
      case 404:
        setError("Username not found!")
        break
      default:
        setUserDetails({...details, role:data.role})
    }
  }


  return (
    <div className = "w-screen h-screen flex">
      {userDetails.username === "" ?
        <LoginForm login = {login} error = {error}>

        </LoginForm>
        :
        userDetails.role === "ADMIN" ? <AdminPage userDetails = {userDetails}/> : <div>todo</div>
        
    }
  </div>
  );
}

export default App;
