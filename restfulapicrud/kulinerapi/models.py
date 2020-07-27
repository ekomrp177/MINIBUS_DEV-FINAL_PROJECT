from django.db import models


# Create your models here.

class Kuliner(models.Model):
    fullname = models.CharField(max_length=100)
    desc = models.TextField(default="")
    alamat = models.TextField(default="")
    jam_buka = models.CharField(max_length=5, default="")
    jam_tutup = models.CharField(max_length=5, default="")
    harga = models.CharField(max_length=11, default="")
    images = models.ImageField('images/')
