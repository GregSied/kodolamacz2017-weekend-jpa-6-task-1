FROM java:8-jre-alpine

COPY test-app.jar /test-app/test-app.jar

ENTRYPOINT java -jar /test-app/test-app.jar

# HEALTHCHECK --interval=3s --timeout=1s --start-period=30s  \
#  CMD test "`wget -qO- localhost:8080/health | jq -r .status`" = "UP"
