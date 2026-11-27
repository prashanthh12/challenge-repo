class Sol:
    def defange(self,address:str)->str:
        return address.replace('.','[.]')
sol=Sol()
val="1.1.1.1"
print("Defange:",sol.defange(val))
