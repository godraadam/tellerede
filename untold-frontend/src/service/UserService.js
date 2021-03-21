
const persistCashier = async ({username, password}, cashier) => {
    const url = 'http://localhost:8080/admin/api/user/register/cashier'
    const response = await fetch(url, {
        method : 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*',
            'Authorization': 'Basic ' + btoa(username + ":" + password)
        },
        body : JSON.stringify(cashier)
    })
    const status = response.status
    const data = await response.json()
    return [data, status]
}

const getCashiers = async({username, password}) => {
    const url = 'http://localhost:8080/admin/api/cashiers'
    const response = await fetch(url, {
        method : 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*',
            'Authorization': 'Basic ' + btoa(username + ":" + password)
        },
    })
    const status = response.status;
    const data = await response.json();
    return [data, status]
}


const loginCall = async ({username, password}) => {
    const url = 'http://localhost:8080/login'
    const response = await fetch(url, {
        method : 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        },
        body : JSON.stringify({
            username:username,
            password:password
        })
    })
    const status = response.status;
    const data = await response.json();
    return [data, status]
}

export {loginCall, getCashiers, persistCashier}