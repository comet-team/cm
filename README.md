## Chat manager

exposes `CRUD` operations on basic entities.

exposes two endoints to create chat for student group and subject group.

## How to run it?

first of all you need to clone this repo and run docker-compose up
`docker-compose up`

also you need container who exposes endpoints to control the bot

1) Set environmental variables `BOT_TOKEN` and `YDISK_OAUTH` in your system
2) clone `https://github.com/comet-team/hse-hack-bot.git` and run `docker-compose up` in it
3) YOU ARE AWESOME

### All endpoins you can find in
`http://{host}:{port}/swagger-ui/`