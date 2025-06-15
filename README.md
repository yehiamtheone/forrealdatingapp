 ## Branches
- `frontend`: Contains JavaFX code  
- `backend`: Contains Node.js/API code  
- `main`: Empty or just documentation 
- `note`: no intentions on my side to merge between front and backend code 
meant for project presentition only.
- frontend cannot be dockerized nor contarized as its purpuse to be a stand alone exe app that can only estblish connect to apis and cannot be as an active app.


### Environment Configuration

- `SOCKET_PORT`: Socket server port (e.g., `4000`) (relavent for front and backend as one as this env var get used in both and not require more than one enviorment conifuration)