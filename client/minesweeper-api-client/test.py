from api import Api

api = Api('http://localhost:8080')
#response = api.create_game('Sebaas', 5, 8)
response = api.click_cell('1ed341f0-fe83-428f-aeb3-f2052f2f2ad2', 0, 6, 'LEFT_CLICK')
print(response)
