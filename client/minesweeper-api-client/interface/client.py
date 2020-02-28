import requests
from exceptions.exceptions import ApiError


class Client(object):

    def __init__(self, url):
        self.url = url
        self.headers ={'Content-type':'application/json', 'Accept': 'application/json'}
        pass

    def create_game(self, player, size, mines):
        data = {
            'playerName': player,
            'size': size,
            'mines': mines
        }
        endpoint = '{}/api/v1/games'.format(self.url)
        response = requests.post(url= endpoint, json=data, headers=self.headers)
        if response.status_code != 201:
            raise ApiError("Error: " + response.content)
        return response.text

    def click_cell(self, game_id, row, column, event):
        data = {
            'row': row,
            'column': column,
            'event': event
        }
        endpoint = '{}/api/v1/games/{}/events'.format(self.url, game_id)
        response = requests.post(url= endpoint, json=data, headers=self.headers)
        if response.status_code != 200:
            raise ApiError("Error: " + response.content)
        return response.text
