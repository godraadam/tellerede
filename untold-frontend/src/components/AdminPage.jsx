import CashierList from './CashierList'
import {persistCashier, getCashiers} from '../service/UserService'
import {getAllConcerts, persistConcert} from '../service/ConcertService'
import {useState, useEffect} from 'react'
import ConcertList from './ConcertList'



const AdminPage = ({userDetails}) => {

    const [cashiers, setCashiers] = useState([])
    const [concerts, setConcerts] = useState([])
    const [cashierError, setCashierError] = useState("")
    const [concertError, setConcertError] = useState("")

    const fetchCashiers = async (details) => {
        const [data, ] = await getCashiers(details)
        setCashiers(data)
    }

    const fetchConcerts = async (details) => {
        const data = await getAllConcerts(details)
        setConcerts(data)
    }

    const registerCashier = async (cashierDetails) => {
        const [data, status] = await persistCashier(userDetails, cashierDetails)
        switch(status) {
            case 422:
                setCashierError("Invalid username and/or password!")
                break
            case 409:
                setCashierError("Cashier with given username already exists!")
                break
            default:
                setCashiers([...cashiers, data])
        }  
    }

    const addConcert = async (concert) => {
        if (concert.startingDate == "" || concert.endingDate == "") {
            setConcertError("Invalid starting and/or endind date!")
            return
        }
        const [data, status] = await persistConcert(userDetails, concert)
        switch(status) {
            case 422:
                setConcertError("Invalid input(s)!")
                break
            default:
                setConcerts([...concerts, data])
        }
        
    }

    useEffect(() => fetchCashiers(userDetails), [cashiers, userDetails])
    useEffect(() => fetchConcerts(userDetails), [concerts, userDetails])
    return (
        <div className = "flex sm:flex-col md:flex-row p-8 w-full sm:items-center md:items-start justify-around">
            <CashierList cashiers = {cashiers} addCashier = {registerCashier} error = {cashierError}/>
            <ConcertList concerts = {concerts} addConcert = {addConcert} error = {concertError}/>
        </div>
    )
}

export default AdminPage