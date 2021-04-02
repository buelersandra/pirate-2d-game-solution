How to run
- Open terminal and change directory to project root folder
- Create an image in the docker container with the command
docker build -t pirate_image .
- Expose accessibility to REST api methods with the command
docker run -d --name pirate_app -p 8080:8080 pirate_image