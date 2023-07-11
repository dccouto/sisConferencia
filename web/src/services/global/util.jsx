import ServiceStorage from '../storage'

export const getHeaders = (params = {}) => {
    const token = ServiceStorage.getToken()

    const config = {
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json',
            Authorization: token ? 'Bearer '.concat(token) : '',
        },
        params,
        timeout: 60000,
    }

    return config
}

export const getHeadersFiles = (onProgress) => {
    const token = ServiceStorage.getToken()

    let config = {
        headers: {
            Accept: 'application/json',
            'Content-Type': 'multipart/form-data',
            Authorization: token ? 'Bearer '.concat(token) : '',
        },
        timeout: 500000,
        onUploadProgress: ({ total, loaded }) => {
            onProgress({ percent: Math.round((loaded / total) * 100).toFixed(2) })
        },
    }

    return config
}
