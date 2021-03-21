import {useState} from 'react'



const LoginForm = ({login, error}) => {

    

    const [password, setPassword] = useState("");
    const [username, setUsername] = useState("");

    const onSubmit = e => {
        e.preventDefault()
        login({username : username, password:password})
    }

    return(
        
        <div className = "flex flex-col justify-center w-1/3 h-1/3 bg-gray-300 m-auto shadow-xl rounded p-8">
            <form onSubmit = {onSubmit}>
                <div className = "flex flex-row h-8/9">
                    <div className = "flex flex-col flex-wrap  w-1/3  mx-1 my-auto">
                        <label className = "my-2 font-display bg-gray-400 rounded shadow-md w-full text-right p-2">
                            Username:
                        </label>
                        <label className = "my-2 font-display bg-gray-400 rounded shadow-md w-full text-right p-2">
                            Password:
                        </label>
                    </div>
                    <div className = "flex flex-col flex-wrap  w-2/3 content-start ml-2 my-auto">
                        <input className = "bg-white-200 my-2 p-2 w-full rounded shadow-md text-center" type = "text" onChange = {e => setUsername(e.target.value)}/>
                        <input className = "bg-white-200 my-2 p-2 w-full rounded shadow-md text-center" type = "password" onChange = {e => setPassword(e.target.value)}/>
        
                    </div>
                    
                </div>
                <input value="Login" className = "w-full self-center my-1 p-2 font-display hover:bg-green-100 bg-gray-400 rounded shadow-md" 
                type = "submit"/>
                <div className = "w-full self-center my-1 font-display text-red-600 text-center" >{error}</div>
            </form>
        </div>
        

    )
}

export default LoginForm