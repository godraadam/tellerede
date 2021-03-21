
const addTicket = async ({username, password}, ticket) => {
    const url = `/api/ticket/sell`
    const response = await fetch(url, {
        method : 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*',
            'Authorization': 'Basic ' + btoa(username + ":" + password)
        },
        body : JSON.stringify(ticket)
    })
    const status = response.status
    if (status == 409) {
        console.log("Unable to sell more tickets!")
        return
    }
    const data = await response.json()
    return data
}

const getTicketsForConcert = async ({username, password}, concertID) => {
    const url = `http://localhost:8080/api/ticket/${concertID}`
    const response = await fetch(url, {
        method : 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*',
            'Authorization': 'Basic ' + btoa(username + ":" + password)
        },
    })
    const data = await response.json()
    return data
}

export {addTicket, getTicketsForConcert}