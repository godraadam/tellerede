
const getAllConcerts = async ({username, password}) => {
    const url = `http://localhost:8080/api/concert/all`
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

const getConcertsByGenre = async ({username, password}, genre) => {
    const url = `http://localhost:8080/api/concert/genre/${genre}`
    const response = await fetch(url, {
        method : 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*',
            'Authorization': 'Basic ' + btoa(username + ":" + password)
        },
    })
    const status = response.status
    if (status == 400) {
        console.log("No such genre!")
        return
    }
    const data = await response.json()
    return data
}

const getConcertsByPerformer = async ({username, password}, performer) => {
    const url = `http://localhost:8080/api/concert/performer/${performer}`
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

const persistConcert = async ({username, password}, concert) => {
    const url = `http://localhost:8080/api/concert/add`
    const response = await fetch(url, {
        method : 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*',
            'Authorization': 'Basic ' + btoa(username + ":" + password)
        },
        body : JSON.stringify(concert)
    })
    const status = response.status
    const data = await response.json()
    return [data, status]
}

export {persistConcert, getConcertsByGenre, getConcertsByPerformer, getAllConcerts}