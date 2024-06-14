# syntax=docker/dockerfile:1
FROM nginx:stable-alpine-slim

COPY nginx.conf /etc/nginx/nginx.conf
COPY kezboard.conf /etc/nginx/kezboard.conf

COPY 404.html /usr/share/nginx/html/404.html