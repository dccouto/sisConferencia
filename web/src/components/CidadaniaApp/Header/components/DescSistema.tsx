import { useDrawer } from '../../Drawer/hooks/useDrawer'

export function DescSistema() {
    const { isDesktop } = useDrawer()

    const imageSize = isDesktop ? 50 : 40

    return (
        <a href='/'>
            <div style={{ display: 'flex', flexDirection: 'row', alignItems: 'center' }}>
                

                <div
                    style={{
                        width: 200,
                        height: 50,
                        marginLeft: 10,
                        position: 'relative',
                        display: 'flex',
                        alignItems: 'flex-end',
                    }}
                >
                    <div
                        style={{
                            position: 'absolute',
                            width: '100%',
                            left: 0,
                            fontSize: isDesktop ? 36 : 30,
                            color: '#15D2B6',
                            fontWeight: 'bold',
                        }}
                    >
                        SIS
                    </div>
                    <div
                        style={{
                            position: 'absolute',
                            width: '100%',
                            paddingLeft:isDesktop ?'30%':'25%',
                            left: 0,
                            fontSize: isDesktop ? 36 : 30,
                            color: '#1351B4',
                            fontWeight: 'bold',
                        }}
                    >
                        Conferência
                    </div>
                   
                </div>
            </div>
        </a>
    )
}
