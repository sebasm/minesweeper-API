from interface.client import Client as _Client

import json as _json


class Api(object):

    def __init__(self, url):
        self.client = _Client(url)

    def create_game(self, name, size, mines):
        response = self.client.create_game(name, size, mines)
        json_response = _json.loads(response)
        return json_response

    def click_cell(self, game_id, row, column, click_type):
        response = self.client.click_cell(game_id, row, column, click_type)
        json_response = _json.loads(response)
        return json_response
