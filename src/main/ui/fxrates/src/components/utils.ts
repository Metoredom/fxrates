import moment from 'moment'

export function formatDate(value: string){
    return moment(value, 'YYYY-MM-DDTHH:mm:ss.sss').format('DD.MM.YYYY')
}