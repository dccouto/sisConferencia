ARG REGISTRY=docker.io/library

# build
FROM ${REGISTRY}/node:16 AS build
WORKDIR /home/app/
COPY ./ ./
RUN npm install -g npm@8.4.0 && npm install && npm run build

# image
FROM nginxinc/nginx-unprivileged:1.21-alpine AS image
COPY --chown=nginx --from=build /home/app/build/ /home/app/html
COPY --chown=nginx --from=build /home/app/docker/default.conf /etc/nginx/conf.d/
COPY --chown=nginx --from=build /home/app/docker/proxy.conf /etc/nginx/

ENV TZ="America/Sao_Paulo"
ENTRYPOINT ["sh", "-c", "nginx -g 'daemon off;'"]
