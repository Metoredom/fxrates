export async function getRates(){
    const response = await fetch('/api/getRates')
    return await response.json()
}

export async function getCurrencies() {
    const response = await fetch('/api/getCurrencies')
    return await response.json()
}

export async function getHistory(ccy:string) {
    const response = await fetch('/api/getRateHistory?ccy='+ccy)
    return await response.json()
}