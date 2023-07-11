export function compareMenuPaths(locationPath: string, itemPath?: string, childrenPath?: string[]): boolean {
    if (itemPath && locationPath === itemPath) {
        return true
    }

    if (childrenPath) {
        const padraoRegex = '[/a-z]+'
        const locationPathFiltered = locationPath.match(padraoRegex)![0]
        return childrenPath.some((item) => {
            const itemFiltered = item.match(padraoRegex)![0]

            const caminhoAbsoluto = itemFiltered === locationPathFiltered
            const caminhoRelativo = itemPath + '/' + itemFiltered === locationPathFiltered

            return caminhoAbsoluto || caminhoRelativo
        })
    }

    return false
}
