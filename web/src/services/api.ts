import axios from 'axios'

let host = process.env.REACT_APP_API_ENTRYPOINT

axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*'

export const api = axios.create({
    baseURL: host,
})
