#**How to run application**
1. Open terminal and change directory to project root folder
   `$ cd \root\of\project`
2. Create an image in the docker container with the command
    `docker build -t pirate_image .`
3. Expose accessibility to REST api methods with the command
    `docker run -d --name pirate_app -p 8080:8080 pirate_image`


REST method paths example
1. `POST /map` 

    - To submit a 2d map of PirateMap(type:String,amount:Optional<Object>)

2. `GET /findPath?=startXPosition=0&startYPosition=0&targetXPosition=3&targetYPosition=3` 

    - Returns the path taken to collect as much treasure possible. PiratePath(path: List<List<Integer>>, coins: int)