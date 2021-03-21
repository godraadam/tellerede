import {useState} from 'react'

const inputStyle = "flex rounded shadow-md bg-gray-500 text-black text-l my-2 p-2 justify-between"
const buttonStyle = "mx-auto my-1 rounded text-sm shadow-md bg-gray-200 px-2 py-1 hover:bg-gray-400 text-grey-900 uppercase text-center"

const CashierList = ({cashiers, addCashier, error}) => {

    const [showAddCashier, setShowAddCashier] = useState(false)
    const [cashierUsername, setCashierUsername] = useState("")
    const [cashierPassword, setCashierPassword] = useState("")

    const onAddCashier = async () => {
        await addCashier({username:cashierUsername, password:cashierPassword})
        error !== "" && setShowAddCashier(false)
    }

    const onCancel = () => {
        setShowAddCashier(false)
        setCashierPassword("")
        setCashierUsername("")
    }

    return (
        <div className = "flex flex-col w-96 bg-gray-300 rounded shadow-md p-4 m-4">
            <div className = "flex text-sm text-gray-200 justify-center items-center bg-gray-600 w-full h-10 rounded shadow-md uppercase">Cashiers</div>
            <ul className = "w-full">
                {
                    cashiers.map(c => 
                        <li key = {c.id} className = "mx-auto my-2 rounded shadow-md bg-gray-100 px-2 py-1 hover:bg-gray-200">
                            <div className = "w-full text-l">{c.username}</div>
                            <div className = "text-gray-400">{c.role.toLowerCase()} </div>
                        </li>
                    )
                }
                {
                    showAddCashier && <form className = 'my-2 mx-1'>
                        <div className = {inputStyle}>
                            <label>Username:</label>
                            <input type = "text" className = "text-center rounded" onChange = {e => setCashierUsername(e.target.value)}/>
                        </div>
                        <div className = {inputStyle}>
                            <label>Password:</label>
                            <input type = "password" className = "text-center rounded" onChange = {e => setCashierPassword(e.target.value)}/>
                        </div>
                        <div className = "w-full self-center my-1 font-display underline text-red-400 text-center">{error}</div>
                        <div className = {buttonStyle}  onClick = {onCancel}>Cancel</div>
                    </form>
                }
                <li className = {buttonStyle} onClick = {showAddCashier ? onAddCashier : () => setShowAddCashier(true)}>Add cashier</li> 
            </ul>
        </div>
    )
}

export default CashierList