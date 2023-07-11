const ServiceStorage = {
    setItem: function (name: string, item: any) {
        localStorage.setItem(`@mrs:${name}`, JSON.stringify(item))
    },

    getItem: function (name: string) {
        const item = localStorage.getItem(`@mrs:${name}`)

        if (!item) return false

        return JSON.parse(item)
    },

    removeItem: function (name: string) {
        localStorage.removeItem(`@mrs:${name}`)
    },

    setToken: function (token: string) {
        return sessionStorage.setItem(`@mrs:token`, token)
    },

    getToken: function () {
        return sessionStorage.getItem(`@mrs:token`)
    },

    removeToken: function () {
        sessionStorage.removeItem(`@mrs:token`)
    },
}

export default ServiceStorage
