
export const govBrConstants = {
  urlProvider: 'https://sso-des.cidadania.gov.br/govbr/routeReturn/localhost:3000?pathRedirect=/',
  clientId: process.env.REACT_APP_GOV_BR_CLIENT_ID,
  redirectUri: process.env.REACT_APP_GOV_BR_REDIRECT_URI,
  //logoutUri: 'https://sso.acesso.gov.br/logout?post_logout_redirect_uri=https://comidanoprato.cidadania.gov.br/doador/logout',
};