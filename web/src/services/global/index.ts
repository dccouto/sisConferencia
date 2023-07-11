import axios from 'axios'

let baseUrl = process.env.REACT_APP_API_ENTRYPOINT

export * from './util'

const success = (response: any) => {
    if (response.data.error) {
        return Promise.reject(response.data)
    }
    return response.data
}

const error = (error: any) => {
    if (error.response.status === 401) {
        // localStorage.clear()
        // sessionStorage.clear()
        return Promise.reject('Não autorizado!')
    }

    if (error.response.status === 500) {
        return Promise.reject(error.response.data)
    }

    return Promise.reject(error.response.data)
}

const api = axios.create({
    baseURL: baseUrl,
})

api.interceptors.response.use(success, error)

export default api
