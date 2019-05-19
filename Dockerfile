FROM ruby:alpine3.9
RUN mkdir app
ADD app.rb Gemfile app/
RUN cd app/ && ls -l && bundle install
EXPOSE 4567
CMD ruby app/app.rb -p 4567 -o 0.0.0.0