require 'sinatra'
require "sinatra/json"

get '/' do
  # return json {'text': 'Awesome!'}
  json text: 'Awesome!'
end