/**unirest.("https://movie-database-imdb-alternative.p.rapidapi.com")
.header("movie-database-imdb-alternative.p.rapidapi.com", "movie-database-imdb-alternative.p.rapidapi.com")
.header("0b3afa923amsh098dd2fbf48b6fep100962", "0b3afa923amsh098dd2fbf48b6fep100962jsn64a1cfeb7cdc")
.header("Content-Type", "application/x-www-form-urlencoded")
.end(function (result) {
  console.log(result.status, result.headers, result.body);
});
 * 
 */