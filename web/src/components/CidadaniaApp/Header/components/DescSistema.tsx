import { useDrawer } from '../../Drawer/hooks/useDrawer'

export function DescSistema() {
    const { isDesktop } = useDrawer()

    const imageSize = isDesktop ? 50 : 40

    return (
        <a href='/'>
            <div style={{ display: 'flex', flexDirection: 'row', alignItems: 'center' }}>
                <img src='/logo.png' style={{ width: imageSize, height: imageSize }} alt='SISCONFERÊNCIA' />

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
                            top: isDesktop ? 0 : 3,
                            fontSize: isDesktop ? 17 : 14,
                            color: '#0080ff',
                            fontWeight: 'bold',
                        }}
                    >
                        SIS
                    </div>
                    <div
                        style={{
                            fontSize: isDesktop ? 36 : 30,
                            color: 'rgb(181 182 185)',
                            fontWeight: 'bold',
                            lineHeight: isDesktop ? 0.9 : 1.2,
                        }}
                    >
                        CONFERÊNCIA
                    </div>
                </div>
            </div>
        </a>
    )
}
