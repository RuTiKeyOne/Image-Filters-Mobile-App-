package com.mobiledev.imagefilters.ViewModels;

import android.app.Application;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.mobiledev.imagefilters.Repository.EditImageRepositoryImp;

public class EditViewModel extends AndroidViewModel {
    EditImageRepositoryImp editImageRepository;

    public EditViewModel(@NonNull Application application) {
        super(application);
        editImageRepository = new EditImageRepositoryImp(application.getApplicationContext());
    }

    public Bitmap prepareImageView(Uri imageUri){
        return editImageRepository.prepareImagePreview(imageUri);
    }

}
