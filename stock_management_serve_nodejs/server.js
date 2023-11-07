const express = require('express');
const bodyParser = require('body-parser');

const app = express();
app.use(bodyParser.json());

app.get('/', (req, res) => {
  res.json({ message: 'Ahoy! From Server!!' });
});

app.listen(4000, () => {
  console.log('Application is running on port 4000');
});