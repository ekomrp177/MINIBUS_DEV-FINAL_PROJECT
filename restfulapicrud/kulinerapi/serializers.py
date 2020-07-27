from rest_framework import serializers
from .models import Kuliner


class KulinerSerializer(serializers.ModelSerializer):
    class Meta:
        model = Kuliner
        fields = '__all__'
