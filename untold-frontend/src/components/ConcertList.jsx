import {useState} from 'react'

const inputStyle = "flex rounded shadow-md bg-gray-500 text-black text-l my-2 p-2 justify-between"
const buttonStyle = "mx-auto my-1 rounded text-sm shadow-md bg-gray-200 px-2 py-1 hover:bg-gray-400 text-grey-900 uppercase text-center"

const ConcertList = ({concerts, addConcert, error}) => {

    const [showAddConcert, setShowAddConcert] = useState(false)
    const [concertToAdd, setConcertToAdd] = useState({title:"", performer:"", genre:"", startingDate:"", endingDate:"", maxTicketCount:0})

    const onAddConcert = async () => {
        await addConcert(concertToAdd)
        error !== "" && setShowAddConcert(false)
    }

    const onCancel = () => {
        setShowAddConcert(false)
        setConcertToAdd({title:"", performer:"", genre:"", startingDate:"", endingDate:"", maxTicketCount:0})
    }

    return (
        <div className = "flex flex-col w-96 bg-gray-300 rounded shadow-md p-4 m-4">
            <div className = "flex text-sm text-gray-200 justify-center items-center bg-gray-600 w-full h-10 rounded shadow-md uppercase">Concerts</div>
            <ul className = "w-full">
                {
                    concerts.map(c => 
                        <li key = {c.id} className = "mx-auto my-2 rounded shadow-md bg-gray-100 px-2 py-1 hover:bg-gray-200">
                            <div className = "w-full text-l font-semibold">{c.performer + " : " + c.title}</div>
                            <div className = "text-gray-400">{c.genre.toLowerCase()} </div>
                            <div className = "text-gray-400">{new Date(c.startingDate).toLocaleString("ro-RO") + " - " + new Date(c.endingDate).toLocaleString("ro-RO")} </div>
                        </li>
                    )
                }
                {
                    showAddConcert && <form className = 'my-2 mx-1'>
                        <div className = {inputStyle}>
                            <label>Title:</label>
                            <input type = "text" className = "text-center rounded" onChange = {e => setConcertToAdd({...concertToAdd, title:e.target.value})}/>
                        </div>
                        <div className = {inputStyle}>
                            <label>Performer:</label>
                            <input type = "text" className = "text-center rounded" onChange = {e => setConcertToAdd({...concertToAdd, performer:e.target.value})}/>
                        </div>
                        <div className = {inputStyle}>
                            <label>Genre:</label>
                            <input type = "text" className = "text-center rounded" onChange = {e => setConcertToAdd({...concertToAdd, genre:e.target.value.toUpperCase()})}/>
                        </div>
                        <div className = {inputStyle}>
                            <label>Staring date and time:</label>
                            <input type = "datetime-local" className = "text-center rounded" onChange = {e => setConcertToAdd({...concertToAdd, startingDate:e.target.value})}/>
                        </div>
                        <div className = {inputStyle}>
                            <label>Ending date and time:</label>
                            <input type = "datetime-local" className = "text-center rounded" onChange = {e => setConcertToAdd({...concertToAdd, endingDate:e.target.value})}/>
                        </div>
                        <div className = {inputStyle}>
                            <label>Tickets for sale:</label>
                            <input type = "number" className = "text-center rounded" onChange = {e => setConcertToAdd({...concertToAdd, maxTicketCount:e.target.value})}/>
                        </div>
                        <div className = "w-full self-center my-1 font-display underline text-red-400 text-center">{error}</div>
                        <div className = {buttonStyle}  onClick = {onCancel}>Cancel</div>
                    </form>
                }
                <li className = {buttonStyle} onClick = {showAddConcert ? onAddConcert : () => setShowAddConcert(true)}>Add concert </li> 
            </ul>
        </div>
    )
}

export default ConcertList