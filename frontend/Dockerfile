FROM node:latest

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

RUN chmod -R 777 /app/node_modules

RUN npm run build

EXPOSE 3000
CMD ["npm","start"]
